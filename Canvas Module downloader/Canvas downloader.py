import os
import requests
import sys
import re
import logging

# Configuration
canvas_domain = "canvas.case.edu"
access_token = "5590~Jc92eCHmDMxNueyXGktNEKDJZByZLFLyHyAJzYeB7EJ7Xx9DTUXXM6MZxreRyy7U"  # Replace with your actual access token
output_dir = "./canvas_downloads"
downloaded_modules_file = "downloaded_modules.txt"  # File to track downloaded modules

# Set up logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

# Create output directory if it doesn't exist
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

# Set up the headers with the access token
headers = {
    'Authorization': f'Bearer {access_token}'
}

# Function to sanitize directory names
def sanitize_directory_name(name):
    return re.sub(r'[<>:"/\\|?*]', '_', name)

# Function to get the list of all courses
def get_courses():
    courses = []
    url = f"https://{canvas_domain}/api/v1/courses"
    while url:
        response = requests.get(url, headers=headers)
        response.raise_for_status()
        courses.extend(response.json())
        url = response.links.get('next', {}).get('url')
    return courses

# Function to get the details of a course
def get_course(course_id):
    url = f"https://{canvas_domain}/api/v1/courses/{course_id}"
    response = requests.get(url, headers=headers)
    response.raise_for_status()
    return response.json()

# Function to get the list of modules for a course with pagination
def get_course_modules(course_id):
    modules = []
    url = f"https://{canvas_domain}/api/v1/courses/{course_id}/modules"
    while url:
        response = requests.get(url, headers=headers)
        response.raise_for_status()
        modules.extend(response.json())
        url = response.links.get('next', {}).get('url')
    return modules

# Function to get the items of a module with pagination
def get_module_items(course_id, module_id):
    items = []
    url = f"https://{canvas_domain}/api/v1/courses/{course_id}/modules/{module_id}/items"
    while url:
        response = requests.get(url, headers=headers)
        response.raise_for_status()
        items.extend(response.json())
        url = response.links.get('next', {}).get('url')
    return items

# Function to download a file
def download_file(file_url, output_path):
    try:
        response = requests.get(file_url, headers=headers, stream=True)
        response.raise_for_status()
        with open(output_path, 'wb') as f:
            for chunk in response.iter_content(chunk_size=8192):
                f.write(chunk)
        logger.info(f"Downloaded: {output_path}")
    except requests.exceptions.RequestException as e:
        logger.error(f"Failed to download {file_url}: {e}")

# Function to check if a module has already been downloaded
def is_module_downloaded(module_id):
    if os.path.isfile(downloaded_modules_file):
        with open(downloaded_modules_file, 'r') as f:
            downloaded_modules = f.read().splitlines()
            return str(module_id) in downloaded_modules
    return False

# Function to mark a module as downloaded
def mark_module_as_downloaded(module_id):
    with open(downloaded_modules_file, 'a') as f:
        f.write(str(module_id) + '\n')

# Main function to download materials from modules for all courses
def download_all_courses_files():
    courses = get_courses()
    logger.info(f"Found {len(courses)} courses.")
    
    for course in courses:
        course_id = course['id']
        try:
            course_name = sanitize_directory_name(course['name'])
            logger.info(f"Fetching files for course: {course_name} (ID: {course_id})")
            
            # Create directory for the course
            course_dir = os.path.join(output_dir, course_name)
            if not os.path.exists(course_dir):
                os.makedirs(course_dir)
            
            modules = get_course_modules(course_id)
            for module in modules:
                module_id = module['id']
                module_name = sanitize_directory_name(module['name'])
                logger.info(f"Processing module: {module_name} (ID: {module_id})")
                
                if is_module_downloaded(module_id):
                    logger.info(f"Skipping module {module_name} (ID: {module_id}) as it's already downloaded")
                    continue
                
                module_dir = os.path.join(course_dir, module_name)
                if not os.path.exists(module_dir):
                    os.makedirs(module_dir)
                
                items = get_module_items(course_id, module_id)
                for item in items:
                    if item['type'] == 'File':
                        file_id = item['content_id']
                        file_info = get_file_info(file_id)
                        file_url = file_info['url']
                        file_name = sanitize_directory_name(file_info['display_name'])
                        output_path = os.path.join(module_dir, file_name)
                        download_file(file_url, output_path)
                
                # Mark module as downloaded
                mark_module_as_downloaded(module_id)
            logger.info(f"All modules for course {course_name} (ID: {course_id}) have been processed.")
        except requests.exceptions.HTTPError as http_err:
            logger.error(f"HTTP error occurred for course {course_id}: {http_err}")
        except Exception as err:
            logger.error(f"Error occurred for course {course_id}: {err}")

# Function to get file information
def get_file_info(file_id):
    url = f"https://{canvas_domain}/api/v1/files/{file_id}"
    response = requests.get(url, headers=headers)
    response.raise_for_status()
    return response.json()

# Run the main function
if __name__ == "__main__":
    try:
        download_all_courses_files()
    except Exception as e:
        logger.exception("An error occurred:")
