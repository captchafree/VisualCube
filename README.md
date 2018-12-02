# VisualCube
A java framework that uses [VisualCube](http://cube.crider.co.uk/visualcube.php) to generate static images of Rubik's cubes. It needs an internet connection to generate an image the first time, but caches it so it can be generated again without one.

## Installation
[Download the jar file](https://github.com/jbeck18/VisualCube/blob/master/VisualCube.jar) and add it to your project.

## Tutorial

To generate images you must use the `VisualCube` and `VCAttributes` classes.

The `VCAttributes` class stores the attributes that you want the generated image to have. If none are specified then it uses the default values specified in the table below.

| Function | Description | Value Range | Default |
|----------|:-------------:|:-------------:|:---------:|
| .fileType() | Image format | png \| gif \| jpeg | png |
| .backgroundColor() | Background color | transparent \| black \| dark_gray \| gray \| silver \| white \| yellow \| red \| orange \| blue \| green \| purple \| pink | white |
| .puzzleType() | Puzzle type | 1 - 10 | 3 |
| .imageSize() | Size of the generated image | 0 - 1024 | 128 |
| .view() | Special view | plan \| trans | None |
| .stageMask() | Stage mask | fl \| f2l \| ll \| cll \| ell \| oll \| ocll \| oell \| coll \| ocell \| wv \| vh \| els \| cls \| cmll \| cross \| f2l_3 \| f2l_2 \| f2l_sm \| f2l_1 \| f2b \| line | None |
| .algorithm() | Algorithm to apply | [UDLRFBudlrfbMESxyz'23]* | None |
| .algorithmCase() | Algorithm to solve case | [UDLRFBudlrfbMESxyz'23]* | None |

### Generating Images

To add attributes either create a `VCAttributes` object and add them one at a time

```java
VCAttributes attributes = new VCAttributes();
attributes.backgroundColor(BackgroundColor.TRANSPARENT);
attributes.algorithm("S2 E2 M2");
```

or chain them together

```java
VCAttributes attributes = new VCAttributes()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithm("S2 E2 M2");
```


Then, either generate a `BufferedImage` object

```java
BufferedImage result = VisualCube.getImageWithAttributes(attributes);
```

or directly save the generated image to a file

```java
VisualCube.saveImageWithAttributesToFile(attributes, "CubeImage");
```


### Examples

#### Example 1

```java
VCAttributes attributes = new VCAttributes();
VisualCube.saveImageWithAttributesToFile(attributes, "examples/example_1");
```

![Solved Cube](https://github.com/jbeck18/VisualCube/blob/master/examples/example_1.png "Example 1")

#### Example 2

```java
VCAttributes attributes = new VCAttributes()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithm("S2 E2 M2")
                .imageSize(250);

VisualCube.saveImageWithAttributesToFile(attributes, "examples/example_2");
```

![Checkerboard Pattern Cube](https://github.com/jbeck18/VisualCube/blob/master/examples/example_2.png "Example 2")

#### Example 3

```java
VCAttributes attributes = new VCAttributes()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithmCase("R U R'")
                .stageMask(StageMaskType.F2L)
                .imageSize(250);

VisualCube.saveImageWithAttributesToFile(attributes, "examples/example_3");
```

![F2L Stage Cube](https://github.com/jbeck18/VisualCube/blob/master/examples/example_3.png "Example 3")
