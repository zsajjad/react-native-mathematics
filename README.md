# React Native Mathematics

Running sophisticated mathematical calculations on native thread

## Installation

```sh
npm install react-native-mathematics # or yarn add react-native-mathematics
```

## Usage

```js
import Mathematics from "react-native-mathematics";

// ...

const result = await Mathematics.calculate({
  addition: {
    formula: "a+b",
    values: {
      a: 5,
      b: 10
    },
  },
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
