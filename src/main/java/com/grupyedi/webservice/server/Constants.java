package com.grupyedi.webservice.server;

public class Constants {

    public static final String CONFIG_LOCATION = "server-settings.config";

    public static final String GREET_HTML = "<!DOCTYPE html><html><head><meta charset=\\\"utf-8\\\"><title>Cinema WebService.md</title><style></style></head><body id=\\\"preview\\\">\n" +
            "    <h1 class=\\\"code-line\\\" data-line-start=0 data-line-end=1><a id=\\\"Cinema_WebService_0\\\"></a>Cinema WebService</h1>\n" +
            "    <blockquote>\n" +
            "    <p class=\\\"has-line-data\\\" data-line-start=\\\"2\\\" data-line-end=\\\"5\\\">Cinema WebService is an API service for<br>\n" +
            "    operations and accesses to cinema services,<br>\n" +
            "    intended for client applications.</p>\n" +
            "    </blockquote>\n" +
            "    <h2 class=\\\"code-line\\\" data-line-start=6 data-line-end=7><a id=\\\"Features_6\\\"></a>Features</h2>\n" +
            "    <ul>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"7\\\" data-line-end=\\\"8\\\">Access to available movie sessions</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"8\\\" data-line-end=\\\"9\\\">Access to available movies</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"9\\\" data-line-end=\\\"10\\\">Access to saloons</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"10\\\" data-line-end=\\\"11\\\">Authentication server for users</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"11\\\" data-line-end=\\\"12\\\">Authentication server for admins</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"12\\\" data-line-end=\\\"13\\\">Ticket buying service</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"13\\\" data-line-end=\\\"14\\\">Access to users public data</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"14\\\" data-line-end=\\\"16\\\">Authenticated access to managing database for admins</li>\n" +
            "    </ul>\n" +
            "    <h3 class=\\\"code-line\\\" data-line-start=16 data-line-end=17><a id=\\\"Tech_16\\\"></a>Tech</h3>\n" +
            "    <p class=\\\"has-line-data\\\" data-line-start=\\\"18\\\" data-line-end=\\\"19\\\">Webservice Tech stack:</p>\n" +
            "    <ul>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"20\\\" data-line-end=\\\"21\\\">Java - main language used for server and all of the bussiness logic.</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"21\\\" data-line-end=\\\"22\\\">Hibernate - framework used for managing connections to SQL database.</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"22\\\" data-line-end=\\\"23\\\">Javalin - library used for opening endpoints and serving the server.</li>\n" +
            "    <li class=\\\"has-line-data\\\" data-line-start=\\\"23\\\" data-line-end=\\\"25\\\">AWS - for hosting.</li>\n" +
            "    </ul>\n" +
            "    <h2 class=\\\"code-line\\\" data-line-start=29 data-line-end=30><a id=\\\"HTTP_Requests_for_Endpoints_Table_29\\\"></a>HTTP Requests for Endpoints Table</h2>\n" +
            "    <table class=\\\"table table-striped table-bordered\\\">\n" +
            "    <thead>\n" +
            "    <tr>\n" +
            "    <th>Endpoint</th>\n" +
            "    <th>Description</th>\n" +
            "    <th>Method</th>\n" +
            "    </tr>\n" +
            "    </thead>\n" +
            "    <tbody>\n" +
            "    <tr>\n" +
            "    <td><a href=\"movies\"> /movies</a></td>\n" +
            "    <td>All available movies</td>\n" +
            "    <td>GET</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"movie-sessions\"> /movie-sessions</a></td>\n" +
            "    <td>Available and non available movie sessions</td>\n" +
            "    <td>GET</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"genres\"> /genres</a></td>\n" +
            "    <td>All available genres</td>\n" +
            "    <td>GET</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"saloons\"> /saloons</a></td>\n" +
            "    <td>All available saloons</td>\n" +
            "    <td>GET</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"tickets\"> /tickets</a></td>\n" +
            "    <td>All available ticket options</td>\n" +
            "    <td>GET</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"users/login\"> /users/login</a></td>\n" +
            "    <td>Attempt to login user with given json data</td>\n" +
            "    <td>POST</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"users/register\"> /users/register</a></td>\n" +
            "    <td>Attempt to register user with given json data</td>\n" +
            "    <td>POST</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "    <td><a href=\"tickets/purchase\"> /tickets/purchase</a></td>\n" +
            "    <td>Attempt to purchase a ticket with given json data</td>\n" +
            "    <td>POST</td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "    </table>\n" +
            "    </body></html>";

}
