export interface CopyAndroidPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
