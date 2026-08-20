# Project 2: eCommerce Application

## GOAL

Design a complete eCommerce platform using UML diagrams, focusing on complex HasMany and BelongsTo relationships. This project emphasises database normalisation and modelling behaviour that accounts for system failures and edge cases.

The eCommerce system has unique complexities different from social networks—primarily around nested parent-child relationships, inventory management, and payment processing workflows.

---

## REQUIREMENTS

### A. Activity Diagram (Behavioural)

**Purpose:** Model the complete user journey from arriving at the site through to completed purchase, with particular attention to what happens when things go wrong.

**Process to Model:** Full eCommerce flow (8-12 activities minimum)

**Required Activities:**

- Search
- View based on categories
- Viewing products
- Customising products (update quantity, style, etc.)
- Add to cart
- User registration
- View cart
- Update cart
- Checkout
- Payment

**Critical Requirement:** Include validation points throughout. Model what happens when:

- Credit card is declined
- Product is out of stock
- User abandons cart
- Payment processing fails

**Key Principle:** The complexity isn't in the "happy path" where everything works—it's in modelling all the potential failure points and alternative flows.

---

### B. Class Diagram (Structural)

**Purpose:** Design a robust, normalised database structure for an eCommerce system that can scale.

**Required Classes:**

1. User
2. Address
3. City
4. Country
5. Cart
6. CartItem
7. Inventory
8. InventoryItem
9. InventoryOption
10. Taxonomy (or Category)
11. Join table: Inventory ↔ Taxonomy relationship
12. Payment
13. CreditCard
14. PayPal
15. PaymentStatus
16. Order
17. OrderStatus
18. OrderItem

**Key Focus Areas:**

**Database Normalisation:**

- Why separate Address, City, Country into different tables?
- How to prevent data duplication
- Validation benefits of normalised structure

**Complex Relationships:**

- Order hasMany Products (via OrderItems)
- Product belongsTo Inventory
- Many-to-many between Inventory and Taxonomy
- One-to-many between User and Address (critical: many users can share same address)

**Parent-Child Nesting:**

- How does an Order contain multiple OrderItems?
- How does Inventory relate to InventoryOptions?
- The relationship chain: User → Order → OrderItem → Inventory

---

---

## KEY TAKEAWAYS

### Activity Diagram

**Model Failures, Not Just Success:**

- Happy path is easy
- Complexity is in error handling
- Users don't follow perfect flows
- System must handle edge cases gracefully

**Decision Points Define Complexity:**

- More branches = more complex system
- Each decision requires validation logic
- Map out ALL possible user paths

### Class Diagram

**Database Normalisation Matters:**

- Prevent data duplication
- Enable data validation
- Support multiple relationships (addresses)
- Plan for scale from day one

**Separation of Concerns:**

- Payment interface pattern
- Keep different functionalities isolated
- Loose coupling enables maintainability

**Think Long-term:**

- Structure for growth
- Don't paint yourself into architectural corners
- Small decisions now have big impacts later

### Universal Principles

**Break Systems into Smallest Pieces:** The more granular your design, the easier implementation becomes. Each class diagram element translates to a specific database table and model. Each activity becomes a specific validation check.

**Visual Communication:** These diagrams replace dozens of pages of written requirements. A developer can look at them and immediately understand what needs to be built.

**Start High-Level, Then Detail:** Activity diagram first (understand behaviour), then class diagram (implement structure). Never jump straight to code.
