### Java bitCount 算法原型和过程解析

---

1 普通方法

```java
public int bitCount_(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                ++count;
            }
            // 当前数字右移一位，高位补0
            num >>= 1;
        }
        return count;
  }
```

