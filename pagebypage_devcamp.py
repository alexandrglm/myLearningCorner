import pdfkit
import requests
from bs4 import BeautifulSoup

# formatter html
def clean_html(html_content):
    soup = BeautifulSoup(html_content, 'html.parser')

    # Cleaning from other things excepting the lesson
    for script in soup(["script", "style", "meta", "link", "header", "footer", "nav"]):
        script.extract()

    # video issue
    for video_tag in soup.find_all('video'):
        if video_tag.find('source'):
            video_src = video_tag.find('source')['src']
            video_name = video_src.split('/')[-1]  # Extracting video filename
            video_tag.replace_with(f"Video file: {video_name}")

    return str(soup)

def html_to_pdf(cleaned_html, output_pdf_path):
    options = {
        'encoding': 'UTF-8',
        'enable-local-file-access': None
    }
    pdfkit.from_string(cleaned_html, output_pdf_path, options=options)

def process_page(html_content, output_pdf):
    cleaned_html = clean_html(html_content)

    # html to pdf simply
    html_to_pdf(cleaned_html, output_pdf)
    print(f"PDF generado: {output_pdf}")

# get from html, a ver si te lo aprendes.
def get_html_from_url(url):
    try:
        response = requests.get(url)
        if response.status_code == 200:
            return response.text
        else:
            print(f"ERROR {response.status_code}")
            return None
    except Exception as e:
        print(f"Timeout error: {e}")
        return None

# menu
def menu():
    print("=== Conversor HTML a PDF ===")
    print("1. Direct https link?")
    print("2. PATH to source file?")

    option = input("Input?: ")

    if option == '1':

        url = input(Devcamp link??? ")
        html_content = get_html_from_url(url)
        if html_content:
            output_pdf = input("PDF filename???: ")
            process_page(html_content, output_pdf)
    elif option == '2':

        html_file = input("PATH to SOURCE file?: ")
        try:
            with open(html_file, 'r', encoding='utf-8') as file:
                html_content = file.read()
            output_pdf = input("PDF file name?? ")
            process_page(html_content, output_pdf)
        except FileNotFoundError:
            print("File not found, PATH???")
    else:
        print("notvalid_option")

if __name__ == '__main__':
    menu()
