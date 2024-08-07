export interface CopyAndroidPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  copy(options: CopyOptions): Promise<CopyResults>;
}

export type CopyOptions = {
  path: string,
  filename: string,
  directory: string,
};

export type CopyResults = {
  path: string,
};
