import { WebPlugin } from '@capacitor/core';

import type { CopyAndroidPlugin } from './definitions';

export class CopyAndroidWeb extends WebPlugin implements CopyAndroidPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
