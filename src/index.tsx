import { NativeModules } from 'react-native';

type MathematicsType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Mathematics } = NativeModules;

export default Mathematics as MathematicsType;
