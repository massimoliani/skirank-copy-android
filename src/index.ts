import { registerPlugin } from '@capacitor/core';

import type { CopyAndroidPlugin } from './definitions';

const CopyAndroid = registerPlugin<CopyAndroidPlugin>('CopyAndroid', {
  web: () => import('./web').then(m => new m.CopyAndroidWeb()),
});

export * from './definitions';
export { CopyAndroid };
