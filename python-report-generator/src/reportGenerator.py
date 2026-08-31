from pathlib import Path
import json
from jinja2 import Environment, FileSystemLoader

base_dir = Path(__file__).resolve().parent
project_root = base_dir.parent.parent

requirement_path = project_root / "model-data" / "requirements.json"
component_path = project_root / "model-data" / "components.json"
traceability_path = project_root / "model-data" / "traceability.json"
template_folder = base_dir.parent / "templates"

with open(requirement_path, "r", encoding="utf-8") as file:
    requirements_data = json.load(file)

with open(component_path, "r", encoding="utf-8") as file:
    components_data = json.load(file)

with open(traceability_path, "r", encoding="utf-8") as file:
    traceability_data = json.load(file)

requirements = requirements_data["requirements"]
components = components_data["components"]
traceabilities = traceability_data["traceability"]

environment = Environment(
    loader=FileSystemLoader(template_folder)
)

template = environment.get_template("report.md.j2")

report = template.render(
    requirements=requirements,
    components=components,
    traceabilities=traceabilities
)

output_path = project_root / "docs" / "generated-report.md"
output_path.write_text(report, encoding="utf-8")

print(f"Report generated successfully: {output_path}")