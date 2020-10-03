# Requires local registry running
# docker run -d -p 5000:5000 --restart=always --name registry registry
FROM localhost:5000/pakotzy/nanoer
ADD notes.txt /notes.txt
ENTRYPOINT ["/bin/nano", "/notes.txt"]