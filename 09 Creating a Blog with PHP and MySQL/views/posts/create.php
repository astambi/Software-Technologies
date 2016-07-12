<?php $this->title = 'Create New Post'; ?>

<h1>
    <?=htmlspecialchars($this->title)?>
</h1>

<form method="post">
    <div>Title:</div>
    <input type="text" name="post_title">
    <div>Content:</div>
    <textarea name="post_content" rows="10"></textarea>
    <div>
        <input type="submit" value="Create">
        <a href="<?=APP_ROOT?>/posts">[Cancel]</a>
    </div>
</form>