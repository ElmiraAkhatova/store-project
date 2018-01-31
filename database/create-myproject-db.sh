#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres myproject &&
psql -U postgres -d myproject -f "$BASEDIR/schema.sql" &&
psql -U postgres -d myproject -f "$BASEDIR/user.sql" &&
psql -U postgres -d myproject -f "$BASEDIR/data.sql"