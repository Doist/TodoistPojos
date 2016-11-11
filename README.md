# TodoistPojos

TodoistPojos is a Java project which provides the base POJOs for most [Todoist API](https://todoist.com/API/) objects.

The naming follows the same as the API, both for classes, variables and methods, with very few helper methods added.

## Usage

For the most part, you should extend the `Base*` class files and add the necessary logic for your application — persistence, serialization, syncing, etc, whatever you need.

## General considerations

### Temporary ids

Temporary ids are negative `long` values. Regular ids start at 0 and go up from there. The API supports any type of value for temporary ids, so special `String` values would also work. However, this would require an additional field to hold the temporary id, additional logic, and seems completely unecessary for most usages.

The generation of temporary ids is up to the host application, but the algorithm can be really simple: start at -1 and go down from there. An Android application could use something like the following:

```java
public static synchronized long getNextTempId(Context context) {
	SharedPreferences preferences = context.getSharedPreferences("todoist_temp_ids", Context.MODE_PRIVATE);
	SharedPreferences.Editor editor = preferences.edit();
	long id = preferences.getLong("temp_id", 0) - 1;
	if (id > Long.MIN_VALUE) {
		// Save decremented temp id.
		editor.putLong("temp_id", id);
	} else {
		// Restart from -1 in next call.
		editor.remove("temp_id");
	}
	editor.commit();
	return id;
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
