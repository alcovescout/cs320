# cs320
CS320 8-3 Submission

# 1. How can I ensure that my code, program, or softwware is functional and secure?

This can be done through testing. Functional tests should be written for all code created. This ensures the code is going to do exactly what you want it to do. I learned recently that automating linting and other simple syntax checks can even be done using pre-commit hooks to your git repository. So you really don't even need to write a specific CI job to do these types of checks, altough another check does not hurt. Security can be done through tests, as well as scans. Scanning for secrets is a great practice to do to ensure no commits are being added to the repository that include sensitive data. Another tool is scanning your dependcies used within your project for known vulnerablities. This is a must for web projects that rely on a lot of external soruces to run.

# 2. How do I interpret user needs and incorporate them into a program.

This can be done in a multitued of ways. You can collect data by interviewing users, or by collect their usage of a program. If you are on Github, or other public hosting platform, feature requests can be submitted and reviewed. Overall, reviewing what the client's requirements are, and generating a plan is most important. Being transparent with the client is key for them to understand time tables, resource allocations, and overall feasability of "requirements" is a big thing. Conducting user tests of beta builds is another great way to help better understand how a user is going to interact with the product.

# 3. How do I approach desinging software?
All good software should be used to solve an inherent problem. Gathering requirements to solve this problem is the number one thing to do before even writing the first line of code. These requirements are both the functional and non-functional reuqirements. Desing the software starting holeisticly and then breaking that into smaller chunks is a great approach. When writing test early and often to prevent small bugs from holding up realease. Throughout all of this, ensure good documentation is being created.