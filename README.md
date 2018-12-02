# VisualCube
A java framework that uses [VisualCube](http://cube.crider.co.uk/visualcube.php) to generate static images of Rubik's cubes.

## Installation
To use VisualCube all you need to do is [download the jar file](https://github.com/jbeck18/VisualCube/blob/master/VisualCube.jar) and add it to your project.

## Tutorial

To generate images you must use the `VisualCube` and `VCAttributes` classes.

The `VCAttributes` class stores the attributes that you want the generated image to have. If none are specified then it uses the default values specified in the table below.

| Function | Description | Value Range | Default |
|----------|:-------------:|:-------------:|:---------:|
| .fileType() | Image format | png \| gif \| jpg | png |
| .backgroundColor() | Background Color | black \| dark_gray \| gray \| silver \| white \| yellow \| red \| orange \| blue \| green \| purple \| pink | white |
| .puzzleType() | PuzzleType | 1 - 10 | 3 |
| .imageSize() | Size of the generated image | 0 - 1024 | 128 |
| .view() | Special view | plan \| trans | None |
| .stageMask | Stage Mask | fl \| f2l \| ll \| cll \| ell \| oll \| ocll \| oell \| coll \| ocell \| wv \| vh \| els \| cls \| cmll \| cross \| f2l_3 \| f2l_2 \| f2l_sm \| f2l_1 \| f2b \| line | None |
| .algorithm() | Algorithm to apply | [UDLRFBudlrfbMESxyz'23]* | None |
| .algorithmCase() | Algorithm to solve case | [UDLRFBudlrfbMESxyz'23]* | None |

### Creating attributes

To add attributes either create a `VCAttributes` object and add them one at a time

```java
VCAttributes attributes = new VCAttributes();
attributes.backgroundColor(BackgroundColor.TRANSPARENT);
attributes.algorithm("S2 E2 M2");
```

or use the `VCAttributes.Builder`

```java
VCAttributes attributes = new VCAttributes.Builder()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithm("S2 E2 M2")
                .build();
```

### Examples

#### Example 1

```java
VCAttributes attributes = new VCAttributes();
BufferedImage img = VisualCube.getImageWithPreferences(preferences);
```

Result

#### Example 2

```java
VCAttributes attributes = new VCAttributes.Builder()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithm("S2 E2 M2")
                .imageSize(250)
                .build();

VisualCube.saveImageWithPreferencesToFile(preferences, "examples/example_2");
```

Result

#### Example 3

```java
VCAttributes attributes = new VCAttributes.Builder()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithmCase("R U R'")
                .stageMask(StageMaskType.F2L)
                .imageSize(250)
                .build();

VisualCube.saveImageWithPreferencesToFile(attributes, "examples/example_3");
```

Result
