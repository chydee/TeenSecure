package com.j0t1m4.teensecure.data.contents

object RansomWranglerCourse {
    val level1Content = CourseContent(
        levelTitle = "LEVEL 1: BASIC AWARENESS",
        introduction = "Welcome to the Basic Awareness level!",
        description = "This section introduces you to the fundamental concepts of ransomware and general cybersecurity practices. You'll learn how to identify common signs of ransomware infections, such as pop-up messages demanding payment. This level covers essential habits like creating strong passwords, verifying unexpected email attachments, and the importance of regularly updating your software. You'll also be introduced to basic terminology and safe practices to avoid phishing emails and suspicious links. By the end of this level, you'll have a solid foundation to recognize and prevent basic ransomware threats.",
        learningContents = listOf(
            LearningContent("Introduction to Ransomware Awareness", ""),
            LearningContent("Understanding Ransomware", "Imagine waking up to find your computer files locked and a message demanding payment to unlock them. This is ransomware, a malicious software that blocks access to your data until a ransom is paid. Ransomware can target anyone, causing significant disruption and stress."),
            LearningContent("How Ransomware Spreads", "Ransomware often spreads through phishing emails that look legitimate but contain malicious attachments or links. It can also come from malicious downloads, where seemingly harmless files or programs hide ransomware."),
            LearningContent("Recognizing the Signs", "Signs of ransomware include sudden inability to access files and pop-up messages demanding payment. Recognizing these signs early can help minimize damage."),
            LearningContent("Preventing Ransomware Infections", "Use strong, unique passwords, regularly update software, and install reliable antivirus software. Avoid opening suspicious emails or clicking on unfamiliar links."),
            LearningContent("Backup and Recovery", "Regularly back up your data to multiple locations (cloud storage and external drives) and test backups to ensure they work. This way, you can restore your files without paying a ransom if infected."),
            LearningContent("Responding to an Infection", "If infected, disconnect from the internet immediately to prevent the ransomware from spreading. Seek professional help to remove the ransomware and restore data from backups."),
            LearningContent(
                "Everyday Examples",
                "A friend received an email from what appeared to be their bank, asking to verify account details via a link. Suspicious, they called the bank directly and discovered the email was a phishing attempt. Their caution prevented a potential ransomware attack. Another person regularly backed up their important documents to a cloud service. When ransomware hit, they restored their files from the cloud without paying the ransom."
            ),
        ),
        tips = "Stay vigilant, use strong passwords, keep software updated, and back up your data regularly. These steps can help protect against ransomware and keep your data safe.",
        quiz = RwQuestionLists.level1Questions
    )
    val level2Content = CourseContent(
        levelTitle = "LEVEL 2: INTERMEDIATE KNOWLEDGE",
        introduction = "In the Intermediate Knowledge level, you'll dive deeper into the methods ransomware uses to infiltrate systems.",
        description = "This section explains the significance of multi-factor authentication and the dangers of using public Wi-Fi for sensitive transactions. \n" + "You'll also learn about the importance of regular software updates and how antivirus software can protect your devices. Scenario-based questions will help you practice real-life decision-making skills in the event of a ransomware attack. \n" + "By completing this level, you'll be better equipped to implement intermediate security measures and respond effectively to potential ransomware threats.",
        learningContents = listOf(
            LearningContent("Intermediate Level: Enhancing Ransomware Awareness", ""),
            LearningContent("The Threat of Ransomware", "Imagine your computer suddenly displaying a message demanding money to regain access to your files. This is ransomware, designed specifically to encrypt your files and demand a ransom for their release. Recognizing this threat is the first step in protecting yourself"),
            LearningContent("Boosting Security with MFA", "Multi-factor authentication (MFA) adds an extra layer of security by requiring more than one form of verification, such as a password and a code sent to your phone. This makes it significantly harder for attackers to gain access to your accounts."),
            LearningContent("Immediate Actions During an Attack", "If you encounter ransomware, don't panic. Disconnect from the network immediately and seek professional help. Paying the ransom isn't a guarantee you'll get your files back and might encourage further attacks."),
            LearningContent("Safe Online Practices", "Regularly updating your software, using strong passwords, and installing antivirus software are fundamental practices to prevent ransomware infections. Public Wi-Fi, often insecure, should be avoided for sensitive transactions."),
            LearningContent("Identifying Phishing Emails", "Phishing emails look legitimate but are designed to trick you into giving up personal information or downloading malware. Always verify the authenticity of emails, especially those requesting sensitive information."),
            LearningContent("Importance of Backups", "Regularly back up your data and store copies in multiple locations. This ensures you can recover your files without paying a ransom if your system gets infected. Periodically test your backups to confirm they work properly."),
        ),
        tips = "Stay proactive by using multi-factor authentication, updating your software, and backing up your data. These steps will help you stay protected against ransomware.",
        quiz = RwQuestionLists.level2Questions
    )

    val level3Content = CourseContent(
        levelTitle = "LEVEL 3: ADVANCED UNDERSTANDING",
        introduction = "The Advanced Understanding level focuses on more complex aspects of ransomware protection and response.",
        description = "You'll explore various ransomware delivery methods, such as phishing emails, malicious downloads, and software vulnerabilities. \n" + "This level emphasizes the importance of having a robust backup strategy and understanding the role of encryption in protecting data. \n" + "\nYou'll also learn about the immediate steps to take after detecting a ransomware infection, including isolating affected systems and reporting the attack. \n" + "By mastering this level, you'll be prepared to handle advanced ransomware scenarios and implement comprehensive security strategies.",
        learningContents = listOf(
            LearningContent("Ransomware Delivery Methods:", ""),
            LearningContent(
                "Ransomware can infiltrate systems through various methods:",
                "- Phishing Emails: Fake emails tricking you into clicking malicious links or downloading harmful attachments.\n" + "- Malicious Downloads: Downloading software from untrusted sources can introduce ransomware.\n" + "- Software Vulnerabilities: Outdated software can be exploited by ransomware to gain access to your system."
            ),
            LearningContent("Backup Strategies:", "Regular backups are vital for data recovery. Use a mix of cloud and external drive backups. Ensure backups are stored in multiple locations and test them regularly to confirm they work correctly."),
            LearningContent("Encryption and Ransom Notes:", "Ransomware often encrypts your data, making it inaccessible until a ransom is paid. Common traits of ransom notes include demands for payment in cryptocurrencies and threats if the ransom isn't paid."),
            LearningContent("Immediate Actions Post-Infection:", "If you detect ransomware, disconnect from the network to prevent it from spreading. Seek professional help to assess and remove the infection. Avoid paying the ransom, as it doesn't guarantee data recovery."),
            LearningContent(
                "Reporting Attacks:",
                "Reporting ransomware attacks to authorities helps track and combat cybercrime. Contact IT support or cybersecurity professionals for assistance and report the incident to local law enforcement or cybersecurity agencies.\n" + "By understanding and applying these advanced principles, you'll be well-prepared to handle and respond to ransomware infections effectively."
            ),
            LearningContent("Ransomware Scenario:", "Your computer suddenly displays a ransom note demanding payment to unlock your files. You suspect a ransomware attack."),
            LearningContent(
                "Steps to take:", """
               1. Immediately disconnect your computer from the network.
               2. Contact your IT department or a cybersecurity professional for assistance.
               3. Check your most recent backups to ensure they are clean and up-to-date.
               4. Follow the professional's guidance to remove the ransomware and restore your files from backup.
            """.trimIndent()
            ),
            LearningContent("Scenario of Backup", "You are tasked with creating a backup strategy for your team to protect against potential ransomware attacks."),
            LearningContent(
                "Steps to take:", """
               1. Identify the critical data that needs to be backed up.
               2. Choose appropriate backup methods (e.g., cloud storage, external drives).
               3. Schedule regular backups and verify that they are working correctly.
               4. Test the restoration process to ensure you can recover data from the backups.
            """.trimIndent()
            ),
        ),
        tips = "",
        quiz = RwQuestionLists.level3Questions
    )

    val level4Content = CourseContent(
        levelTitle = "LEVEL 4: PROFICIENT KNOWLEDGE",
        introduction = "You'll gain insights into sophisticated cybersecurity practices and tools in the Proficient Knowledge level.",
        description = "This section covers essential features of antivirus software, the benefits of password managers, and the importance of firewalls and regular backups. You'll learn how to verify email senders, recognize phishing attempts, and understand the concept of social engineering. Interactive quizzes and drag-and-drop activities will help reinforce your understanding of network security measures and effective ransomware response plans.",
        learningContents = listOf(
            LearningContent("Antivirus Features", "Reliable antivirus software is crucial for ransomware protection. Key features include real-time scanning, automatic updates, and comprehensive malware detection. Ensure your antivirus is always up-to-date and actively monitoring your system."),
            LearningContent("Password Managers and Strong Passwords", "Password managers help store and generate strong passwords, reducing the risk of weak or reused passwords. Create passwords with a mix of letters, numbers, and special characters to enhance security."),
            LearningContent("Firewall and Backup Strategies", "Firewalls monitor and control incoming and outgoing network traffic, blocking malicious activity. Regular backups ensure you can recover data in case of a ransomware attack. Store backups in multiple locations and verify their integrity regularly."),
            LearningContent("Safe Browsing and Email Verification", "Verify the authenticity of email senders before downloading attachments or clicking links. Look for secure websites (HTTPS) at the top of that URL bar when browsing, and avoid suspicious links to reduce the risk of ransomware."),
            LearningContent("Understanding Social Engineering", "Social engineering attacks manipulate individuals into revealing confidential information. Common tactics include phishing emails, pretexting, and baiting. Stay vigilant and verify requests for sensitive information.")
        ),
        tips = "By mastering these proficient security practices, you'll significantly enhance your defense against ransomware and other cyber threats.",
        quiz = RwQuestionLists.level4Questions
    )

    val level5Content = CourseContent(
        levelTitle = "LEVEL 5: EXPERT LEVEL",
        introduction = "Welcome to the Expert Level, where you'll explore advanced techniques for ransomware prevention and response.",
        description = "This level covers the essential actions to take if you suspect a ransomware attack and the role of IT support in mitigating threats. You'll learn about the importance of clean, current backups and how to verify email authenticity. This section also delves into social engineering attacks and the critical aspects of a comprehensive ransomware response plan.",
        learningContents = listOf(
            LearningContent("Ransomware Response", "If you suspect a ransomware attack, immediately disconnect from the internet to prevent further spread. Contact IT support or cybersecurity professionals for assistance and avoid paying the ransom."),
            LearningContent("Clean and Current Backups", "Regularly update and test your backups to ensure they are clean and current. Before restoring data, verify that your backups are not infected to prevent reintroducing ransomware."),
            LearningContent("Email and URL Verification", "Verify the sender of emails before downloading attachments or clicking links. Look for secure website indicators like HTTPS to ensure you're visiting legitimate sites. Avoid clicking on suspicious links."),
            LearningContent("Advanced Social Engineering Tactics", "Social engineering attacks exploit human behavior to gain access to sensitive information. Examples include phishing, pretexting, and baiting. Stay vigilant and verify requests for information to defend against these attacks."),
            LearningContent("Ransomware Response Plan", "A comprehensive ransomware response plan includes steps for disconnecting infected systems, reporting the incident to authorities, and strategies for data recovery. Regularly review and update your response plan to ensure it's effective.")
        ),
        tips = "By mastering these expert-level practices, you'll be fully prepared to identify, prevent, and respond to sophisticated ransomware threats, ensuring robust security for your systems and data.", quiz = RwQuestionLists.level5Questions
    )


}