Reproduces an issue in ordering of active profiles and multi-document profile-scoped YAML files.

Given a file like `application-dev.yml`

```yaml

---
spring:
  profiles: cloud

my.prop: hi
```

The property `my.prop` will not be loaded if the active profiles are in the order `cloud,dev` instead of `dev,cloud`.

The sole test class in this project demonstrates this.
