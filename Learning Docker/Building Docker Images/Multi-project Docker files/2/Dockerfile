# Creates a temporary image, calculates the size of the Google and saves it to file
FROM ubuntu:16.04 as builder
RUN apt-get -y update
RUN apt-get -y install curl
RUN curl https://google.com | wc -c > google-size

# Copies google-size file from previous image and creates a tiny image with that file inside
FROM alpine
COPY --from=builder /google-size /google-size
ENTRYPOINT echo google is this big; cat google-size