Feature: Installment and no installment product list verification


  #Entegrasyon olarak istemişsiniz fakat en azından an itibariyle yaptığım işe yakın bir örnek sergiledim. Koleksiyon içinde ki API'nin reponse olarak dönüşünde header tanımlamalarında eksiklik olduğundan
  #-polymorphism yöntemi ve REST Assured yardımıyla HTML olan body kısmını JSON'a çevirdim.
  @apiTest
  Scenario: Verify installment product list with given API
    Given I logged in related API with path as "installment=1"
    And   I verify that content type is HTML
    And   I verify that status code is 200
    Then  I convert response to JSON
    Then  I get list of installment products

  @apiTest
  Scenario: Verify not installment product list with given API
    Given I logged in related API with path as "installment=0"
    And   I verify that content type is HTML
    And   I verify that status code is 200
    Then  I convert response to JSON
    Then  I get list of installment products

  @apiTest
  Scenario: Verify that if installment value null there should be Internal Server Error
    Given I logged in related API with query parameter "installment" with "null"
    Then I verify that status code is 500




