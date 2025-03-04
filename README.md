
# munira_s_application7

### **Real-Time Emergency Booking for Students & Doctors**

In critical moments, swift medical access can make all the difference. A real-time meeting booking system designed to bridge the gap between students and doctors. Whether it's an urgent consultation or a scheduled check-up, the platform ensures seamless scheduling and efficient communication.

### **Key Features & Objectives**

✅ **Instant Booking** – Students can schedule emergency medical appointments in real-time.

✅ **Doctor Approvals** – Doctors can accept or reschedule appointments based on availability.

✅ **Live Updates** – Booking details are instantly updated for both parties.

✅ **Secure & Scalable** – Built with a robust backend to handle multiple requests efficiently.

---

### **Tech Stack & Implementation**

🚀 **Tools & Frameworks:**

- **Android Studio** – The powerhouse for UI and logic development.
- **Firebase (Backend & Analytics)** – Real-time data sync, authentication, and insights.
- **Realm Database** – Fast, efficient local data storage.
- **Dependency Injection (DI)** – Streamlined and maintainable code structure.
- **JUnit Testing** – Ensured reliability with rigorous unit tests.

💻 **Languages Used:**

- **Kotlin** – For a modern, concise, and safe Android experience.
- **Java** – Legacy compatibility and performance.

Built with AndroidX Support

Requires Android Studio Arctic Fox | 2020.3.1 or higher.

Current Kotlin Version 1.7.20


### SDK Versions

compileSdkVersion 33

buildToolsVersion "30.0.3"

minSdkVersion 23

targetSdkVersion 33



### Figma design guideline for better accuracy

Read our guidelines to increase the accuracy of design conversion to code by optimizing Figma designs. 
https://docs.dhiwise.com/docs/Designguidelines/intro .

### App Navigation

Check your app\'s UI from the AppNavigation screens of your app.

### Package Structure


```
├── appcomponents       
│ ├── di                 - Dependency Injection Components 
│ │ └── MyApp.kt
│ ├── network            - REST API Call setup
│ │ ├── ResponseCode.kt
│ │ └── RetrofitProvider.kt
│ └── ui                 - Data Binding Utilities
│     └── CustomBindingAdapter.kt
├── constants            - Constant Files
│ ├── IntegerConstants.kt
│ └── StringConstants.kt
├── extensions           - Kotlin Extension Function Files
│ └── Strings.kt
├── modules              - Application Specific code
│ └── example            - A module of Application 
│  ├── ui                - UI handling classes
│  └── data              - Data Handling classes
│    ├── viewmodel       - ViewModels for the UI
│    └── model           - Model for the UI
└── network              - REST API setup
  ├── models             - Request/Response Models
  ├── repository         - Network repository
  ├── resources          - Common classes for API
  └── RetrofitService.kt
```
