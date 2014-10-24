log-o-matic
===========

Tiny logging framework with an optional android adapter

why _another_ logging framework?

quite simple. I wanted the interfact to allow easy formatted strings.

Usage
-----

    private final static Logger log = LogOMatic.getLogger(My.class);
    ...
    log.infof("counted %d pomeranians for owner %s", pomCount, "Joe");
