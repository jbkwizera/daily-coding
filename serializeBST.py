class Node:
    def __init__(self, val, left=None, right=None):
        self.val   = val
        self.left  = left
        self.right = right

def serialize(tree):
    def traverse(x):
        if x:
            vals.append(x.val)
            traverse(x.left)
            traverse(x.right)
        else:
            vals.append(' ')
    vals = []
    traverse(tree)
    return vals
def deserialize(vals):
    vals = iter(vals)
    def populate():
        val = next(vals)
        if val == ' ':
            return
        x = Node(val)
        x.left  = populate()
        x.right = populate()
        return x
    return populate()

def _serialize(tree):
    vals = []
    def inorder(x):
        if x:
            vals.append(x.val)
            inorder(x.left)
            inorder(x.right)
        else:
            vals.append(' ')
    inorder(tree)
    return vals

def _deserialize(vals):
    vals = iter(vals)
    def build_tree():
        val = next(vals)
        if val == ' ':
            return
        root = Node(val)
        root.left  = build_tree()
        root.right = build_tree()
        return root
    return build_tree()


if __name__ == '__main__':
    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert _deserialize(_serialize(node)).left.left.val == 'left.left'
    print('test passed')
