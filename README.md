# skirank-copy-android

Copy Patch for Android from content:// files

## Install

```bash
npm install skirank-copy-android
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`copy(...)`](#copy)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### copy(...)

```typescript
copy(options: CopyOptions) => Promise<CopyResults>
```

| Param         | Type                                                |
| ------------- | --------------------------------------------------- |
| **`options`** | <code><a href="#copyoptions">CopyOptions</a></code> |

**Returns:** <code>Promise&lt;<a href="#copyresults">CopyResults</a>&gt;</code>

--------------------


### Interfaces


#### CopyOptions

| Prop                     | Type                                                                                                        |
| ------------------------ | ----------------------------------------------------------------------------------------------------------- |
| **`dereference`**        | <code>boolean</code>                                                                                        |
| **`overwrite`**          | <code>boolean</code>                                                                                        |
| **`preserveTimestamps`** | <code>boolean</code>                                                                                        |
| **`errorOnExist`**       | <code>boolean</code>                                                                                        |
| **`filter`**             | <code><a href="#copyfiltersync">CopyFilterSync</a> \| <a href="#copyfilterasync">CopyFilterAsync</a></code> |
| **`recursive`**          | <code>boolean</code>                                                                                        |


### Type Aliases


#### CopyResults

<code>{ path: string, }</code>


#### CopyFilterSync

<code>(src: string, dest: string): boolean</code>


#### CopyFilterAsync

<code>(src: string, dest: string): Promise&lt;boolean&gt;</code>


#### CopyOptions

<code>{ path: string, }</code>

</docgen-api>
