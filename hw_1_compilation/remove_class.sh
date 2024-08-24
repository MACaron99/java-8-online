# shellcheck disable=SC1012
# shellcheck disable=SC1001
find . -name "*.class" -typef -print0 | xargs -0 \bin\rm -f
