
Instead of re-implementing the wheel,
we will use the `ArrayList` provided by Java as our data container.
Because it is dynamically sized which could gradually grow in runtime,
so it saves much of our time.

Implement a constructor so it store crucial information and create an ArrayList object.

You might call `ensureCapacity()` on the ArrayList object to make it grow (or shrink) to match the required capacity.

For enlarging, you could also double the current capacity.
By the way, for a long term usage, a growing cap should be bounded.
