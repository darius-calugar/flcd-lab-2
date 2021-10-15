# Symbol Table (using HashTable)
- Collisions are resolved using linked lists
- Hashtable size is constant
- Position inside the symbol table is: p = listIndex * size + hash(token)

## int put(String token):
- Stores a token inside the symbol table
- Average Complexity: `O(α)`
- Pre:
    - Token is not already stored inside the symbol table
- Post:
    - Result is the position of the added token

## String get(int position):
- Average Complexity: `O(α)`
- Post:
    - Result is the token from the given position if it is found
    - Result is `null` if no token is found at that position

## int lookup(String token):
- Average Complexity: `O(α)`
- Post:
    - Result is the position inside the symbol table of a given token
    - Result is `-1` if the token is not found