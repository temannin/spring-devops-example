import csv
import os

with open('target/site/jacoco/jacoco.csv', 'r') as file:
    reader = csv.reader(file)

    # example:
    # ['GROUP', 'PACKAGE', 'CLASS', 'INSTRUCTION_MISSED', 'INSTRUCTION_COVERED', 'BRANCH_MISSED', 'BRANCH_COVERED', 'LINE_MISSED', 'LINE_COVERED', 'COMPLEXITY_MISSED', 'COMPLEXITY_COVERED', 'METHOD_MISSED', 'METHOD_COVERED']
    # ['demo', 'com.example.demo', 'DemoApplication', '8', '0', '0', '0', '3', '0', '2', '0', '2', '0']
    # ['demo', 'com.example.demo', 'HelloWorldController', '75', '0', '10', '0', '12', '0', '9', '0', '4', '0']

    # calculate the total coverage percentage start at the second row
    total_instructions = 0
    total_missed_instructions = 0
    row_idx = 0
    for row in reader:
        if row_idx == 0:
            row_idx += 1
            continue
        total_missed_instructions += int(row[3])
        total_instructions += int(row[3]) + int(row[4])
        row_idx += 1
    
    # Calculate coverage percentage
    coverage_percent = round(100 - (total_missed_instructions / total_instructions * 100), 2)
    
    # Output just the percentage for workflow use
    print(coverage_percent)
