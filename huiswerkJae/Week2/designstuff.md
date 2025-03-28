**1\. Law of Demeter (LoD) – "Don't Talk to Strangers"**

- **Lines involved:**
```
- TransportController --> TransportService : "calls"
- TransportService --> TransportProviderSelector : "uses"
- TransportProviderSelector --> TransportProviderPort : "selects"
```
- **Explanation:**  
  The TransportController interacts only with TransportService, not directly with TransportProviderSelector or any API adapters.
    - This ensures **loose coupling** by preventing objects from knowing too much about internal structures.
    - TransportService acts as a **facade**, reducing direct dependencies between the controller and low-level details like API adapters.

**2\. Encapsulate What Varies (EWV)**

- **Lines involved:**
```
- interface TransportProviderPort {
- +fetchData(request: TransportRequest): TransportResponse
- }
```
- **Explanation:**  
  The TransportProviderPort interface abstracts the interaction with external transport providers.
    - This isolates **potentially changing implementations** (Navitia, Google Maps, Skyscanner) from the rest of the system.
    - New providers can be added without modifying existing logic (aligns with **Open/Closed Principle (OCP)**).

**3\. Strategy Pattern**

- **Lines involved:**
```
- TransportProviderSelector --> TransportProviderPort : "selects"
```
- **Explanation:**  
  The TransportProviderSelector dynamically selects a provider at runtime.
    - Different providers (NavitiaAdapter, GoogleMapsAdapter, SkyscannerAdapter) implement TransportProviderPort, allowing easy switching.
    - This aligns with the **Strategy Pattern**, where multiple interchangeable implementations exist for a given interface.

**4\. Template Method Pattern**

- **Lines involved:**
```
- abstract class ApiCaller {
- +callApi(request: TransportRequest): TransportResponse
- \-login(): void
- \-apiCall(): TransportResponse
- \-checkToken(): void
- }
```
- **Explanation:**  
  The ApiCaller class defines a **template method** (callApi), which outlines steps like authentication (login, checkToken) and making API calls (apiCall).
    - Concrete classes like NavitiaAdapter, GoogleMapsAdapter, and SkyscannerAdapter **inherit from** ApiCaller, reusing logic while allowing API-specific customizations.
    - This pattern **reduces code duplication** and ensures all API calls follow a consistent workflow.

**5\. Composition Over Inheritance (COI)**

- **Lines involved:**
```
- TransportService --> TransportProviderPort : "uses"
```
- **Explanation:**  
  Instead of subclassing, TransportService **delegates** to TransportProviderPort.
    - This allows **flexibility**: new transport providers can be added without modifying TransportService.
    - Promotes **dependency injection**, reducing tight coupling.

**6\. Dependency Inversion Principle (DIP)**

- **Lines involved:**
```
- NavitiaAdapter ..|> TransportProviderPort
- GoogleMapsAdapter ..|> TransportProviderPort
- SkyscannerAdapter ..|> TransportProviderPort
```
- **Explanation:**  
  High-level modules (TransportService, TransportProviderSelector) depend on the **abstraction (TransportProviderPort)**, not concrete implementations.
    - This makes the system more **extensible and testable**.
    - New transport providers can be integrated **without modifying existing code**.

**7\. Open/Closed Principle (OCP)**

- **Lines involved:**
```
- class NavitiaAdapter {
- +fetchData(request: TransportRequest): TransportResponse
- }
- class GoogleMapsAdapter {
- +fetchData(request: TransportRequest): TransportResponse
- }
- class SkyscannerAdapter {
- +fetchData(request: TransportRequest): TransportResponse
- }
```
- **Explanation:**  
  New providers can be added **without modifying** TransportService or TransportProviderSelector, adhering to OCP.

**Summary of Improvements & Possible Changes**

| **Principle / Pattern**            | **Already Implemented** | **Possible Improvement**                                                  |
|------------------------------------|-------------------------|---------------------------------------------------------------------------|
| Law of Demeter (LoD)               | ✅ Applied               | Ensure TransportService doesn’t expose low-level API details.             |
| Encapsulate What Varies (EWV)      | ✅ Applied               | Ensure future API changes only affect adapters.                           |
| Strategy Pattern                   | ✅ Applied               | Allow users to customize provider selection (e.g., cheapest, fastest).    |
| Template Method                    | ✅ Applied               | Could extract common error handling into ApiCaller.                       |
| Composition Over Inheritance (COI) | ✅ Applied               | Avoid inheritance where delegation is possible.                           |
| Dependency Inversion (DIP)         | ✅ Applied               | Ensure DI framework (Spring, etc.) is used for TransportProviderSelector. |
| Open/Closed Principle (OCP)        | ✅ Applied               | Ensure documentation makes it clear how to add new providers.             |