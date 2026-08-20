
## B) Class Diagram

![](./Clases-Principales.png)

**Tweet Class (Central Entity)**

Attributes:

- `id`
- `text`
- `author_id` (reference to User)
- `retweeted` (boolean)
- `created_at` (timestamp)
- `like_count`
- `hashtag`

Operations:

- `new()`
- `create()`
- `edit()` (optional)

**Design Philosophy:** The instructor intentionally omits data types (text, varchar, int) unless they're custom types requiring explanation. This saves time and reduces clutter.

---

### **Critical Concept: Multiplicity**

**Example: Tweet → Like**

```
Tweet (1) ────→ (*) Like
```

**What this means:**

- One tweet can have many likes
- Each like belongs to one tweet
- **Database implication:** The `likes` table must have a `tweet_id` foreign key

**Why multiplicity is critical:** If multiplicity is incorrect, developers will build the wrong database structure and have to refactor later.

---

### **Join Tables (Many-to-Many Relationships)**

**Visual Convention:** Represented with dotted lines to distinguish from regular classes.

**Example: TweetHashtag**

```
Tweet (1) ····→ (*) TweetHashtag (*) ←···· (1) Hashtag
```

**Why dotted lines?**

- Visual distinction: Easy to identify join tables at a glance
- Functional distinction: Join tables have no operations, only IDs
- Dependency ordering: You cannot create `TweetHashtag` until both `Tweet` and `Hashtag` tables exist

**Navigability:** Join tables enable bidirectional queries:

- From Tweet: "Show me all hashtags for this tweet"
- From Hashtag: "Show me all tweets with this hashtag"

---

### **Self-Referential Tables**

**1. Retweet (Self-Referential Join Table)**

```
Retweet
─────────────
original_tweet_id
new_tweet_id
content (optional: for quote tweets)
```

**Concept:** A retweet IS a tweet. No separate class needed—just a reference to itself.

**Real-world example:** When you retweet a friend's post:

1. System creates new tweet record (your retweet)
2. `Retweet` table stores: `original_tweet_id` (friend's tweet) + `new_tweet_id` (your tweet)

---

**2. Following (Self-Referential for Users)**

```
Following
─────────────
follower_id (User A)
following_id (User B)
```

**Relationships:**

```
User (1) ────→ (*) Following (*) ←──── (1) User
```

**This enables:**

- "Show all users that John follows" (query `following_id` where `follower_id = John`)
- "Show all of Mary's followers" (query `follower_id` where `following_id = Mary`)
- **Generate feed:** Retrieve tweets from all users in John's `following_id` list

**Applications beyond social networks:**

- Notification systems
- Organisational hierarchies
- Any system requiring self-referential relationships

**Why it's critical:** Nearly every large-scale application needs this pattern somewhere. Understanding it thoroughly is essential.

---

![](./04_01_01_Twiter_CLASS-DIAGRAM_plantUML.png)


```plantuml
@startuml Project 1: Twitter - CLASS DIAGRAM

!theme plain
skinparam classAttributeIconSize 0
skinparam classFontSize 25

folder "uc PROJECT 1 - TWITTER" {
    class User {

        - userId: int
        - username: string
        - email: string
        - password: string
        - displayName: string
        - bio: string
        - profileImageUrl: string
        - createdAt: DateTime
        - isVerified: bool
        - followersCount: int
        - followingCount: int
        
        + createTweet(content: string): Tweet
        + followUser(user: User): void
        + unfollowUser(user: User): void
        + likeTweet(tweet: Tweet): void
        + retweetTweet(tweet: Tweet): void
        + getUserId(): int
        + getUsername(): string
        + setUsername(username: string): void
        + getEmail(): string
        + setEmail(email: string): void
    }

    class Tweet {

        - tweetId: int
        - content: string
        - authorId: int
        - createdAt: DateTime
        - likesCount: int
        - retweetsCount: int
        - repliesCount: int
        - isRetweet: bool
        - originalTweetId: int
        - hasMedia: bool
        
        + addReply(content: string, author: User): Reply
        + addLike(user: User): void
        + removeLike(user: User): void
        + addRetweet(user: User): Retweet
        + addHashtag(hashtag: Hashtag): void
        + getAuthor(): User
        + getTweetId(): int
        + getContent(): string
        + getLikesCount(): int
        + getRetweetsCount(): int
    }

    class Reply {

        - replyId: int
        - content: string
        - authorId: int
        - originalTweetId: int
        - createdAt: DateTime
        - likesCount: int
        - repliesCount: int
        - parentReplyId: int
        
        + addLike(user: User): void
        + addReply(content: string, author: User): Reply
        + getOriginalTweet(): Tweet
        + getAuthor(): User
        + getReplyId(): int
        + getContent(): string
    }

    class Hashtag {

        - hashtagId: int
        - name: string
        - createdAt: DateTime
        - usageCount: int
        - isBlocked: bool
        
        + incrementUsage(): void
        + getTweets(): List<Tweet>
        + getTrendingScore(): int
        + block(): void
        + unblock(): void
        + getName(): string
        + getUsageCount(): int
    }

    class Like {

        - likeId: int
        - userId: int
        - tweetId: int
        - createdAt: DateTime
        
        + getUser(): User
        + getTweet(): Tweet
        + remove(): void
        + getLikeId(): int
    }

    class Retweet {

        - retweetId: int
        - userId: int
        - originalTweetId: int
        - createdAt: DateTime
        - comment: string
        - isQuoteTweet: bool
        
        + getUser(): User
        + getOriginalTweet(): Tweet
        + addComment(comment: string): void
        + remove(): void
        + getRetweetId(): int
        + getComment(): string
    }

    class Message {

        - messageId: int
        - senderId: int
        - receiverId: int
        - content: string
        - createdAt: DateTime
        - isRead: bool
        - hasMedia: bool
        - isDeleted: bool
        
        + markAsRead(): void
        + getSender(): User
        + getReceiver(): User
        + delete(): void
        + addMedia(image: Image): void
        + getMessageId(): int
        + getContent(): string
        + isReadMessage(): bool
    }

    class Security {

        - securityId: int
        - userId: int
        - passwordHash: string
        - salt: string
        - lastLogin: DateTime
        - failedLoginAttempts: int
        - isAccountLocked: bool
        - twoFactorEnabled: bool
        - recoveryEmail: string
        - sessionToken: string
        
        + validatePassword(password: string): bool
        + lockAccount(): void
        + unlockAccount(): void
        + resetFailedAttempts(): void
        + generateSessionToken(): string
        + enableTwoFactor(): void
        + sendRecoveryEmail(): void
        + getSecurityId(): int
        + isLocked(): bool
    }

    class Location {

        - locationId: int
        - latitude: double
        - longitude: double
        - city: string
        - country: string
        - placeName: string
        - isPublic: bool
        - createdAt: DateTime
        
        + getCoordinates(): string
        + getDistance(otherLocation: Location): double
        + setPublic(isPublic: bool): void
        + getFullAddress(): string
        + getLocationId(): int
        + getCity(): string
        + getCountry(): string
    }

    class Image {

        - imageId: int
        - fileName: string
        - fileUrl: string
        - fileSize: int
        - mimeType: string
        - width: int
        - height: int
        - altText: string
        - uploadedAt: DateTime
        - uploadedBy: int
        
        + resize(width: int, height: int): Image
        + compress(): void
        + getUploader(): User
        + setAltText(text: string): void
        + delete(): void
        + getImageId(): int
        + getFileUrl(): string
        + getFileSize(): int
    }

    ' Relaciones principales
    User ||--o{ Tweet : "Crea"
    User ||--o{ Reply : "Crea"
    User ||--o{ Message : "Envía"
    User ||--o{ Message : "Recibe"
    User ||--|| Security : "Tiene"
    User ||--o| Location : "Está localizado en"
    User ||--o| Image : "Tiene de Foto de Perfil"

    Tweet ||--o{ Reply : "Tiene"
    Tweet ||--o{ Like : "Recibe"
    Tweet ||--o{ Retweet : "Es de Retweet"
    Tweet ||--o| Location : "Escrito en"
    Tweet ||--o{ Image : "Contiene"

    ' Relaciones many-to-many
    User }|--|| Like : "Da"
    Tweet }|--|| Like : "Recibe"
    User }|--|| Retweet : "Hace"
    Tweet }|--|| Retweet : "Es de Retweet"
    Tweet }|--|{ Hashtag : "Contiene"

    ' Relaciones de seguimiento
    User ||--o{ User : "Sigue a"

    ' Relaciones con mensajes e imágenes
    Message ||--o{ Image : "Contiene"

    ' Relación jerárquica de replies
    Reply ||--o{ Reply : "Respuesta de"
}


@enduml
```
