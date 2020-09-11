<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<hmtl>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie service - Add movie</title>
    </head>
    <body>
        <div>
            Movie Service
        </div>
        <div>
            Add Movie

            <div class="movie-form">
                <form:form action="addMovieFromView" method="post" modelAttribute="movieForm">
                    <div>
                        <div class="label">Movie name</div>
                        <div><form:input path="name" /></div>
                    </div>
                    <div>
                        <div class="label">Release year</div>
                        <div><form:input path="releaseYear" /></div>
                    </div>
                    <div>
                        <input type="submit" value="Add movie" />
                    </div>
                </form:form>
            </div>

        </div>
    </body>
</html>
