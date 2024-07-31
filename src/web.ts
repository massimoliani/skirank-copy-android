import { WebPlugin } from '@capacitor/core';

import type { CopyAndroidPlugin, CopyOptions, CopyResults } from './definitions';

export class CopyAndroidWeb extends WebPlugin implements CopyAndroidPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async copy(options: CopyOptions): Promise<CopyResults> {
    console.log("Current options:", options);
    return Promise.reject("Error: Copy Not Impmenented in Web");
  }
}
