# Project Setup Guide

## Apache Server Configuration

We use Apache as our web server for this project. Inside the `resources` package, you'll find a folder named `Apache`.

### Existing Apache Server

If you already have an Apache server installed, please update your existing `lib` folder with the `lib` folder provided in our `Apache` directory to ensure compatibility.

### New Apache Server

If you do not have an Apache server, simply utilize the entire `Apache` folder from our `resources` package to set up the server.

## Database Setup

The `HRhealthcheck` folder within the `resources` package contains the database files for this project. To integrate these files, move the `HRhealthcheck` folder into the `Data` directory located within your MySQL Server directory.

## IntelliJ IDEA Configuration

1. Open the project in IntelliJ IDEA.
2. Switch the configuration to Apache server mode.
3. Run the project.
