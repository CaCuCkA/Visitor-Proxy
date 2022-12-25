# Lab 13. Visitor, Proxy

## Description

A simple example of the Visitor & Proxy. Introduction to `JSOUP`

## Plan

- [x] Check what is <a href="https://docs.celeryq.dev/en/stable/">Celery</a>. Run `app.py` to understand why do we need
  Celery.
- [x] Setup Flask-Celery demo from <a href="https://github.com/testdrivenio/flask-celery.git">GIT</a>. Use `test.http`
  to explore.
- [x] Check the documentation of <a href="https://docs.celeryq.dev/en/latest/userguide/canvas.html#stamping">Stamping
  API</a> in Celery. Investigate Stamping API source code.
- [x] Check the information about Visitor on <a href="https://refactoring.guru/design-patterns/visitor">Refactoring
  Guru</a> and <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Wikipedia</a>.
- [x] Complete Task 1.
- [x] Test <a href="https://jsoup.org/">JSOUP</a> and how to scrape websites.
- [x] Check how to send raw HTTP request. Check PDL example.
- [x] Check the information about Proxy on <a href="https://refactoring.guru/design-patterns/proxy">Refactoring Guru</a>
  and <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Wikipedia</a>
- [x] Complete Task 2.
- [x] Submit a link to GitHub with tests and a GitHub Action file.

## Task 1

<p>Implement Stamping API in Java. The goal is to reimplement Stamping 
API in Java for a simplified framework. The framework consists of:</p>

* `interface Task`, an interface of building unit;
* `class Signature` that represents the smallest unit in framework and single task invocation;
* `class Group` that represents the list of signatures, and when the group is
  called, the tasks will be applied one after another in the current process.

You need to implement Stamping API and Group Stamping in a similar manner as it is done in Celery.
When the `apply` method is called for Group Stamping, there should happen an automatic stamping of the `Signature`
with the `groupId`. Stamps are stored in the group header.

## Task 2

<p>Implement scrapping service for <a href="https://www.newhomesource.com/">NewHomeSource</a> with Proxy template. 
If there the link is already scrapped extract it from the cache, else run the 
link again. Use the JDBC library to store links in SQLite DB. Use JSoup to parse HTML, if needed.</p>