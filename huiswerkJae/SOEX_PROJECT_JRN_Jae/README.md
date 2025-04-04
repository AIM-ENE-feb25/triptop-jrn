🔹 Law of Demeter (LoD)

✅ No direct access to object internals.

✅ Calls only well-defined methods (fetchData(request)).

✅ Selector shields external API details.


--- 
🔹 Integration Without Dependency on API Implementations

✅ We use abstraction (TransportProviderPort).

✅ We inject adapters dynamically (@Autowired).

✅ If an API changes, only its adapter updates (not the entire system).

✅ We can easily add or remove new transport services without breaking old ones.