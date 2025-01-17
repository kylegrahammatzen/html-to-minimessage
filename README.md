# Html2MM

`Html2MM` is a Minecraft plugin designed for Paper 1.21 servers. This plugin converts HTML with MiniMessage-supported options into a MiniMessage message using Paper's built-in support for Adventure. For more information on MiniMessage, visit the [Adventure MiniMessage documentation](https://docs.advntr.dev/minimessage/index.html).

## Features

- Convert HTML input into MiniMessage format.
- Support for various MiniMessage options including colors, formatting, and more.
- Example command to demonstrate functionality.

## Example Command

The plugin includes an example command `/html` which does not require any permissions by default.

**Example Usage:**

```html
/html drexican <yellow>★ 
<p>Hi, my name is Charlie and I’m a <strong>software developer</strong>. I like:</p>
<ul>
  <li>Option 1</li>
  <li>Option 2</li>
  <li>Option 3</li>
</ul>
<p>Thats all for now</p>
```

When executed, this command converts the HTML into a MiniMessage that can use colors and formatting:
![Example Output](example_output.png)

## Installation

1. Download the latest release of the plugin.
2. Place the plugin JAR file into the `plugins` directory of your Paper server.
3. Restart the server to load the plugin.

## Usage

Once installed, you can use the `/html` command as shown in the example. The command requires a player and any text after will be converted into a MiniMessage format.

## Building MiniMessages

For users who prefer not to use HTML, you can build MiniMessages directly using the [Adventure WebUI](https://webui.advntr.dev/). This tool provides an intuitive interface for creating MiniMessages without needing to write HTML.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request or open an issue on GitHub.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

- [Adventure MiniMessage documentation](https://docs.advntr.dev/minimessage/index.html)
- [Adventure WebUI](https://webui.advntr.dev/)