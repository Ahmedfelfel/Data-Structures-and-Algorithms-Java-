
Implement 3 kinds of traversal:

1. Preorder (P-L-R)
2. Inorder (L-P-R)
3. Postorder (L-R-P)

which are easily done by changing the sequence
where

- **P** is to process the node
- **L** is to recur on the left subtree
- **R** is to recur on the right subtree

You shall use `processor.accept(t.key)` to process a node.