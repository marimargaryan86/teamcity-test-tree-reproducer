# TeamCity Test Tree Reproducer

This project generates a large JUnit 5 test tree to reproduce a TeamCity UI issue:
Test Pipeline TW-96821 Inability to select 'Specific' branch monitoring mode during pipeline creation

Test Pipeline TW-96821 Inability to select 'Specific' branch monitoring mode during pipeline creation 2 
> **Build Overview → Unit Tests: "Expand all" does not expand tests hidden under "Show all"**

## Project Structure

```
src/test/java/com/example/
├── pkg01/          (10 test classes × 10 methods = 100 tests)
├── pkg02/          (10 test classes × 10 methods = 100 tests)
├── pkg03/          (10 test classes × 10 methods = 100 tests)
├── pkg04/          (10 test classes × 10 methods = 100 tests)
├── pkg05/          (10 test classes × 10 methods = 100 tests)
├── pkg06/          (10 test classes × 10 methods = 100 tests)
├── pkg07/          (10 test classes × 10 methods = 100 tests)
└── pkg08/          (10 test classes × 10 methods = 100 tests)

Total: 8 packages × 10 classes × 10 methods = 800 tests
```

## Requirements

- Java 21+
- Maven 3.6+

## How to Run Locally

```bash
# Run all tests and generate surefire XML reports
mvn test

# Reports will be in: target/surefire-reports/
```

## TeamCity Build Configuration

### Build Step

Add a **Maven** build step with the following configuration:

| Setting | Value |
|---------|-------|
| Goals | `clean test` |
| Maven version | Default (or specify 3.6+) |
| JDK | Java 21 |

Alternatively, use a **Command Line** build step:

```bash
mvn clean test
```

### Build Features

TeamCity should automatically detect JUnit XML reports from `target/surefire-reports/*.xml`.

If not, add a **XML Report Processing** build feature:
- Report type: **Ant JUnit**
- Monitoring rules: `target/surefire-reports/*.xml`

## How to Confirm the Issue

1. **Run the build** in TeamCity.

2. **Go to Build Overview** → look at the **Tests** tab or the **Unit Tests** block.

3. **Verify "Show all" appears:**
   - With 800 tests across 8 packages, TeamCity will truncate the visible list
   - You should see a **"Show all"** link at the bottom of the test tree

4. **Reproduce the bug:**
   - Click **"Expand all"** → only visible nodes expand
   - Click **"Show all"** → more tests appear
   - Notice that newly revealed tests are **collapsed**
   - **Expected:** "Expand all" should expand ALL tests including those under "Show all"
   - **Actual:** Tests hidden under "Show all" remain collapsed

## Test Naming Convention

All tests follow a predictable naming pattern:

```
com.example.pkgXX.ClassYYYTest.testZZZ()
```

Where:
- `XX` = package number (01-08)
- `YYY` = class number within package (001-010)
- `ZZZ` = test method number within class (001-010)

Example: `com.example.pkg03.Class005Test.test007()`

## Customization

To generate more/fewer tests, you can:
1. Add/remove package directories
2. Add/remove test classes within packages
3. Add/remove `@Test` methods within classes

The current configuration (800 tests) reliably triggers the "Show all" behavior in TeamCity.

## License

MIT - Use freely for testing and bug reproduction.
