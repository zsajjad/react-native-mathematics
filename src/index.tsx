import { NativeModules } from 'react-native';

type MathematicsType = {
  calculate(
    formulae: Record<
      string,
      {
        formula: string;
        values: Record<string, number>;
      }
    >
  ): Promise<Record<string, number>>;
};

const { Mathematics } = NativeModules;

export default Mathematics as MathematicsType;
