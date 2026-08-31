from fastapi import FastAPI
from pathlib import Path
import json

app =  FastAPI()

base_dir = Path(__file__).resolve().parent
project_root = base_dir.parent.parent

requirement_path = project_root / "model-data" / "requirements.json"
component_path = project_root / "model-data" / "components.json"
traceability_path = project_root / "model-data" / "traceability.json"

with open(requirement_path, "r", encoding="utf-8") as file:
    requirements_data = json.load(file)

with open(component_path, "r", encoding="utf-8") as file:
    components_data = json.load(file)

with open(traceability_path, "r", encoding="utf-8") as file:
    traceability_data = json.load(file)

requirements = requirements_data["requirements"]
components = components_data["components"]
traceabilities = traceability_data["traceability"]


@app.get("/")
def root():
    return {"message": "smart medical Monitoring API"}


@app.get("/requirements")
def get_requirements():
    return {"requirements": requirements}


@app.get("/components")
def get_components():
    return {"components": components}


@app.get("/traceability")
def get_traceability():
    return {"traceability": traceabilities}

requirement_ids = {requirement["id"] for requirement in requirements}
component_ids = {component["id"] for component in components}
traceability_requirement_ids = {
    traceability["requirementId"]
    for traceability in traceabilities
}

@app.post("/validate")
def validate_model():
    errors=[]

    for traceability in traceabilities:
        requirement_id = traceability["requirementId"]

        if requirement_id not in requirement_ids:
            errors.append(
                f"traceability references missing requirement: {requirement_id}" 
            )

    for traceability in traceabilities:
        for component_id in traceability["componentIds"]:
            if component_id not in component_ids:
                errors.append(
                    f"Traceability references missing component: {component_id}"
                )

    for requirement in requirements:
        if requirement["id"] not in traceability_requirement_ids:
            errors.append(
                f"Requirement has no traceability link: {requirement['id']}"
            )

    seen_requirement_ids = set()

    for requirement in requirements:
        requirement_id = requirement["id"]

        if requirement_id in seen_requirement_ids:
            errors.append(
                f"Duplicate requirement ID: {requirement_id}"
            )
        else:
            seen_requirement_ids.add(requirement_id)

    seen_component_ids = set()

    for component in components:
        component_id = component["id"]

        if component_id in seen_component_ids:
            errors.append(
                f"Duplicate component ID: {component_id}"
            )
        else:
            seen_component_ids.add(component_id)

    return{
        "valid":len(errors) ==0,
        "errors": errors
    }