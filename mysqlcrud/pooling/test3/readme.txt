<prepared-statement-cache-size>100</prepared-statement-cache-size>
  <shared-prepared-statements>true</shared-prepared-statements>

  The first line enables the prepared statement cache and sets the size of the cache.
  This should be large enough to hold all the prepared statements across any and all deployed applications using this particular data source
  (multiple data sources can be configured).
  The second line states that if two requests are executed in the same transaction the prepared statement cache should return the same statement.
  This will avoid the use of CPU cycles in preparing the same statements over and over again, increasing throughput and decreasing response times.
  The actual improvement will vary according to specific circumstances but is well worth the effort


  > Dans CRUDService, ajoutePersonne et supprimePersonne ne font qu'un statement par connection
