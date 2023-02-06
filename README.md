> **Warning** — Not actively maintained.

# TodoistPojos

TodoistPojos is a JVM project which provides the base POJOs (in Kotlin) for most [Todoist API](https://developer.todoist.com/sync/v8/) objects.

The naming follows the same as the API, both for classes, variables and methods, with very few helper methods added.

## Usage

These models are usable out of the box. All models and their properties are open to allow subclassing and overriding.

## General considerations

### Temporary ids

Temporary ids are negative `long` values. Regular ids start at 0 and go up from there. The API supports any type of value for temporary ids, so special `String` values would also work. However, this would require an additional field to hold the temporary id, additional logic, and seems completely unecessary for most usages.

The generation of temporary ids is up to the host application, but the algorithm can be really simple: start at -1 and go down from there. An Android application could use something like the following:

```kotlin
@Synchronized
fun getNextTempId(context: Context): Long {
    val preferences = context.getSharedPreferences("todoist_temp_ids", MODE_PRIVATE)
    val id = preferences.getLong("temp_id", 0) - 1
    preferences.edit().apply {
        if (id > Long.MIN_VALUE) {
            // Save decremented temp id.
            putLong("temp_id", id)
        } else {
            // Restart from -1 in next call.
            remove("temp_id")
        }
        apply()
    }
    
    return id
}
```

## License

    Copyright (c) 2016 Doist

    Permission is hereby granted, free of charge, to any person obtaining
    a copy of this software and associated documentation files (the
    "Software"), to deal in the Software without restriction, including
    without limitation the rights to use, copy, modify, merge, publish,
    distribute, sublicense, and/or sell copies of the Software, and to
    permit persons to whom the Software is furnished to do so, subject to
    the following conditions:

    The above copyright notice and this permission notice shall be
    included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
    LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
    OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
    WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
