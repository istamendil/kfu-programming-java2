#!/usr/bin/env bash
OUTDIR="$PWD/out/production/Threads Examples"
CLASS="ru.kpfu.itis.ex4varaccess.App"
cd "$OUTDIR"
for i in {1..10}
do
  echo "Run #$i"
  java $CLASS
done
