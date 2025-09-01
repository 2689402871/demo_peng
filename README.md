# String Processing Tool

A Java-based string processing library developed using the Template Method pattern for efficiently handling consecutive duplicate characters in strings.

## Features

- **Remove Consecutive Duplicate Characters**: Delete three or more consecutive identical characters
- **Replace Consecutive Duplicate Characters**: Replace consecutive characters with the previous letter in the alphabet
- **Input Validation**: Automatic validation for lowercase letter strings only
- **Processing History**: Returns results from each processing step for easy tracking
- **Template Method Design**: Highly extensible architecture using design patterns

## Technical Architecture

### Design Pattern
This project uses the **Template Method Pattern**:
- `StringHandler` abstract class defines the algorithm skeleton
- `RemoveConsecutiveImpl` and `ReplaceConsecutiveImpl` implement specific processing logic
- Supports future expansion of new processing strategies

### Core Components
```
src/
├── handler/
│   ├── StringHandler.java          # Abstract template class
│   └── impl/
│       ├── RemoveConsecutiveImpl.java    # Removal strategy implementation
│       └── ReplaceConsecutiveImpl.java   # Replacement strategy implementation
├── service/
│   ├── StringServer.java           # Service interface
│   └── impl/
│       └── StringServerImpl.java   # Service implementation
├── untils/
│   └── StringUtil.java             # String utility class
└── StringServerImplTests.java      # Unit tests
```

## Usage

### Basic Usage

```java
// Create service instance
StringServer stringServer = new StringServerImpl();

// Remove consecutive duplicate characters
List<String> removeResult = stringServer.removeConsecutive("aabcccbbad");
// Result: ["aabbbad", "aaad", "d"]

// Replace consecutive duplicate characters
List<String> replaceResult = stringServer.replaceConsecutive("aabcccbbad");
// Result: ["aabbbbad", "aaaad", "d"]
```

### API Description

#### 1. Remove Consecutive Characters
```java
/**
 * Remove three or more consecutive identical characters
 * @param str Input string (must be lowercase letters only)
 * @return History list of processing steps
 */
List<String> removeConsecutive(String str);
```

#### 2. Replace Consecutive Characters
```java
/**
 * Replace three or more consecutive identical characters with previous letter
 * Note: 'a' will be replaced with empty string
 * @param str Input string (must be lowercase letters only)
 * @return History list of processing steps
 */
List<String> replaceConsecutive(String str);
```

### Input Requirements
- String must contain only lowercase letters (a-z)
- Cannot be empty string, blank string, or null
- Cannot contain numbers, uppercase letters, special characters, or spaces

## Examples

### Example 1: Remove Consecutive Characters
```java
String input = "aabcccbbad";
List<String> result = stringServer.removeConsecutive(input);
// Processing steps:
// 1. Find "ccc" and remove → "aabbbad"
// 2. Find "bbb" and remove → "aaad" 
// 3. Find "aaa" and remove → "d"
// Final result: ["aabbbad", "aaad", "d"]
```

### Example 2: Replace Consecutive Characters
```java
String input = "aabcccbbad";
List<String> result = stringServer.replaceConsecutive(input);
// Processing steps:
// 1. Find "ccc" replace with "b" → "aabbbbad"
// 2. Find "bbb" replace with "a" → "aaaad"
// 3. Find "aaa" replace with "" → "d"
// Final result: ["aabbbbad", "aaaad", "d"]
```

### Example 3: Edge Cases
```java
// Invalid inputs return empty list
stringServer.removeConsecutive("abc123"); // Returns: []
stringServer.removeConsecutive("");       // Returns: []
stringServer.removeConsecutive(null);     // Returns: []
```

## Development Extension

### Adding New Processing Strategies

1. Create new implementation class extending `StringHandler`
2. Implement the `specificMethod` method

```java
@Slf4j
public class CustomHandlerImpl extends StringHandler {
    @Override
    protected String specificMethod(Matcher matcher, String str) {
        String group = matcher.group();
        // Implement custom processing logic
        String processedStr = str.replace(group, "custom");
        log.info("Processed: {}", processedStr);
        return processedStr;
    }
}
```

3. Register new strategy in the service layer
```java
public class StringServerImpl implements StringServer {
    private final StringHandler customHandler = new CustomHandlerImpl();
    
    public List<String> customMethod(String str) {
        return customHandler.run(str);
    }
}
```

## Testing

The project includes comprehensive unit tests. Run with:

```bash
mvn test
```

Test coverage includes:
- Utility method tests
- Removal functionality tests
- Replacement functionality tests
- Edge case tests
- Invalid input tests