Poisoned tar
===============

Busybox based image that contains a tar that whenever invoked with `-cf -` arguments will create a poisoned tar with
an entry `../youve-been-hacked`

```shell
$ tar -cf - src >
$ tar xvfP test.tar
```
