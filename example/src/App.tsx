import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import Mathematics from 'react-native-mathematics';

export default function App() {
  const [result, setResult] = React.useState<any>();

  React.useEffect(() => {
    Mathematics.calculate({
      minimumMonthlyInstalment: {
        formula: 'a+b',
        values: {
          a: 2,
          b: 3,
        },
      },
      maximumMonthlyInstalment: {
        formula: 'a-b',
        values: {
          a: 2,
          b: 3,
        },
      },
    }).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {JSON.stringify(result)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
