package com.j0t1m4.teensecure.data.contents

object TeenSecureCourse {
    // Phishing Topic
    val phishingBeginner = CourseContent(
        levelTitle = "Beginner Level: Phishing", introduction = "Phishing is a type of cyberattack where attackers try to trick you into giving away personal information by pretending to be someone you trust.", description = "This level focuses on recognizing phishing attacks and learning basic security habits to avoid falling victim to them.", learningContents = listOf(
            LearningContent("Avoiding Suspicious Links", "Don’t click on strange links or download attachments from unknown sources."), LearningContent("Staying Safe", "Look out for signs like spelling errors or urgent requests for personal information."), LearningContent("Basic Terms", "Phishing: Fake messages to steal your info. Spoofing: Pretending to be someone else online.")
        ), tips = "Always verify requests for personal information before taking any action.", quiz = TeenSecureQuestionLists.phishingLevel1Questions
    )
    val phishingIntermediate = CourseContent(
        levelTitle = "Intermediate Level: Phishing", introduction = "At this level, phishing attacks become more sophisticated, often using personal details gathered from other sources to appear legitimate.", description = "You'll learn how to identify more convincing phishing attacks and check URLs for authenticity.", learningContents = listOf(
            LearningContent("Avoiding Convincing Scams", "Be extra careful with emails asking for personal information, even if they look real."), LearningContent("Staying Safe", "Use two-factor authentication (2FA) for added security."), LearningContent("Basic Terms", "Phishing: Fake messages to steal your info. Two-Factor Authentication (2FA): Extra step to confirm your identity.")
        ), tips = "Double-check the legitimacy of any message before responding.", quiz = TeenSecureQuestionLists.phishingLevel2Questions
    )
    val phishingAdvanced = CourseContent(
        levelTitle = "Advanced Level: Spear Phishing", introduction = "Advanced phishing attacks, or spear phishing, involve highly targeted approaches that use detailed personal information to craft convincing messages.", description = "Learn to protect yourself from targeted scams by recognizing highly personalized phishing attempts.", learningContents = listOf(
            LearningContent("Avoiding Targeted Scams", "Be cautious of highly personalized messages asking for personal information."), LearningContent("Staying Safe", "Secure your social media accounts and review privacy settings."), LearningContent("Basic Terms", "Spear Phishing: Highly targeted phishing attacks. Social Engineering: Tricks to reveal personal info.")
        ), tips = "Stay updated on security practices and regularly review privacy settings.", quiz = TeenSecureQuestionLists.phishingLevel3Questions
    )

    // Baiting Topic
    val baitingBeginner = CourseContent(
        levelTitle = "Beginner Level: Baiting", introduction = "Baiting is a cyberattack where attackers lure you into giving away personal information by offering something appealing.", description = "This level focuses on recognizing baiting attempts and avoiding offers that seem too good to be true.", learningContents = listOf(
            LearningContent("Avoiding Baiting", "Be cautious with offers for free stuff online, especially if it seems too good to be true."), LearningContent("Staying Safe", "Only download content from trusted sources and use antivirus software."), LearningContent("Basic Terms", "Baiting: Tricking you with free offers. Malware: Harmful software that can damage your device.")
        ), tips = "Avoid downloading content from untrusted websites.", quiz = TeenSecureQuestionLists.baitingLevel1Questions
    )
    val baitingIntermediate = CourseContent(
        levelTitle = "Intermediate Level: Baiting", introduction = "At this level, baiting attacks become more convincing, often appearing as legitimate software updates or important-looking documents.", description = "Learn how to avoid more sophisticated baiting attacks by verifying the source of software and documents.", learningContents = listOf(
            LearningContent("Avoiding Convincing Baits", "Be cautious with unexpected software updates and files."), LearningContent("Staying Safe", "Always download updates from official sources."), LearningContent("Basic Terms", "Baiting: Fake updates or documents used to steal info or spread malware.")
        ), tips = "Use antivirus software to detect and block malicious downloads.", quiz = TeenSecureQuestionLists.baitingLevel2Questions
    )
    val baitingAdvanced = CourseContent(
        levelTitle = "Advanced Level: Baiting", introduction = "Advanced baiting attacks involve using sophisticated techniques like fake websites that look identical to real ones or embedding malware in files.", description = "This level focuses on protecting yourself from personalized and highly convincing baiting attacks.", learningContents = listOf(
            LearningContent("Avoiding Advanced Baits", "Be cautious of seemingly legitimate websites and files."), LearningContent("Staying Safe", "Regularly update your antivirus software and enable two-factor authentication."), LearningContent("Basic Terms", "Fake Website: Sites designed to steal your information. Embedded Malware: Harmful software hidden in files.")
        ), tips = "Double-check URLs and avoid downloading files from untrusted sources.", quiz = TeenSecureQuestionLists.baitingLevel3Questions
    )

    // Impersonation Topic
    val impersonationBeginner = CourseContent(
        levelTitle = "Beginner Level: Impersonation", introduction = "Impersonation is when someone pretends to be someone else to gain your trust and access your personal information.", description = "This level teaches you how to recognize fake profiles and verify the identity of people you interact with online.", learningContents = listOf(
            LearningContent("Avoiding Impersonation", "Be cautious with messages from unknown people. Verify their identity through other means."), LearningContent("Staying Safe", "Don’t share personal info without verifying the person."), LearningContent("Basic Terms", "Impersonation: Pretending to be someone else to steal info. Fake Profiles: False social media accounts.")
        ), tips = "Always verify the identity of the person before sharing any personal information.", quiz = TeenSecureQuestionLists.impersonationLevel1Questions
    )

    val impersonationIntermediate = CourseContent(
        levelTitle = "Intermediate Level: Impersonation", introduction = "Impersonation attacks at this level are more sophisticated, involving well-crafted messages and convincing fake profiles.", description = "Learn to recognize more sophisticated impersonation attempts and verify the legitimacy of the people contacting you.", learningContents = listOf(
            LearningContent("Avoiding Convincing Impersonations", "Be careful with messages asking for personal info."), LearningContent("Staying Safe", "Regularly update your privacy settings."), LearningContent("Basic Terms", "Fake Profiles: Realistic false accounts. Verification: Checking if someone is who they say they are.")
        ), tips = "Verify messages from familiar people through a different contact method.", quiz = TeenSecureQuestionLists.impersonationLevel2Questions
    )

    val impersonationAdvanced = CourseContent(
        levelTitle = "Advanced Level: Impersonation", introduction = "Advanced impersonation attacks involve extensive research on the target, creating highly believable fake personas.", description = "This level focuses on protecting yourself from highly targeted impersonation attacks by recognizing subtle inconsistencies.", learningContents = listOf(
            LearningContent("Avoiding Advanced Impersonations", "Be cautious of messages from people asking for personal info, even if they seem genuine."),
            LearningContent("Staying Safe", "Limit personal information shared online and use strong privacy settings."),
            LearningContent("Basic Terms", "Believable Personas: Fake identities created using detailed info. Inconsistencies: Small errors that can reveal a fake.")
        ), tips = "Review social media privacy settings regularly and limit the information available to others.", quiz = TeenSecureQuestionLists.impersonationLevel3Questions
    )

    // Cyberbullying Topic
    val cyberbullyingBeginner = CourseContent(
        levelTitle = "Beginner Level: Cyberbullying", introduction = "Cyberbullying is when someone uses the internet to harass, threaten, or embarrass another person.", description = "This level teaches you how to avoid engaging with cyberbullies and how to protect yourself online.", learningContents = listOf(
            LearningContent("Avoiding Cyberbullying", "Don’t engage with or respond to bullies online. Block and report them."), LearningContent("Staying Safe", "Keep your personal information private and share only with trusted people."), LearningContent("Basic Terms", "Cyberbullying: Harassing someone online. Privacy: Keeping your personal info safe.")
        ), tips = "Be kind and respectful to others online.", quiz = TeenSecureQuestionLists.cyberbullyingLevel1Questions
    )

    val cyberbullyingIntermediate = CourseContent(
        levelTitle = "Intermediate Level: Cyberbullying", introduction = "At this level, cyberbullying involves more coordinated efforts, such as group bullying or spreading harmful content about someone.", description = "Learn how to recognize and avoid more sophisticated forms of cyberbullying, including group bullying.", learningContents = listOf(
            LearningContent("Avoiding Coordinated Bullying", "Block and report all accounts involved in group bullying."), LearningContent("Staying Safe", "Keep profiles private and report any instances of bullying."), LearningContent("Basic Terms", "Group Bullying: Multiple people targeting one person. Fake Accounts: Profiles created to hide the bully’s identity.")
        ), tips = "Document and report instances of bullying to trusted adults or platforms.", quiz = TeenSecureQuestionLists.cyberbullyingLevel2Questions
    )

    val cyberbullyingAdvanced = CourseContent(
        levelTitle = "Advanced Level: Cyberbullying",
        introduction = "Advanced cyberbullying involves more persistent and targeted efforts to harm a person’s reputation or mental health through online harassment.",
        description = "This level focuses on dealing with serious and long-term forms of cyberbullying, such as defamation, doxxing (publishing private information), and trolling across multiple platforms.",
        learningContents = listOf(
            LearningContent("Recognizing Serious Bullying", "Understand when cyberbullying crosses into more severe threats, such as doxxing or personal defamation."),
            LearningContent("Staying Safe", "Limit the amount of personal information shared online. Report serious threats to both platforms and authorities."),
            LearningContent("Basic Terms", "Doxxing: Publishing private information online. Trolling: Harassing someone online to provoke emotional responses.")
        ),
        tips = "Report any form of cyberbullying that escalates to threats of violence or the publishing of personal information.", quiz = TeenSecureQuestionLists.cyberbullyingLevel3Questions
    )


    val phishingTopic = Topic(
        topicTitle = "Phishing", levels = listOf(
            phishingBeginner, phishingIntermediate, phishingAdvanced
        )
    )
    val baitingTopic = Topic(
        topicTitle = "Baiting", levels = listOf(
            baitingBeginner, baitingIntermediate, baitingAdvanced
        )
    )
    val impersonationTopic = Topic(
        topicTitle = "Impersonation", levels = listOf(
            impersonationBeginner, impersonationIntermediate, impersonationAdvanced
        )
    )
    val cyberbullyingTopic = Topic(
        topicTitle = "Cyberbullying", levels = listOf(
            cyberbullyingBeginner, cyberbullyingIntermediate, cyberbullyingAdvanced
        )
    )
    val teenSecureTopics = listOf(
        phishingTopic, baitingTopic, impersonationTopic, cyberbullyingTopic
    )


}