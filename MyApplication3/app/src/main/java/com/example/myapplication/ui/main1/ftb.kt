
package com.example.myapplication.ui.main1
/*
class ftb {

    private lateinit var db: FirebaseDatabase
    private lateinit var adapter: FriendlyMessageAdapter

    // Initialize Realtime Database
    db = Firebase.database
    val messagesRef = db.reference.child(MESSAGES_CHILD)

    // The FirebaseRecyclerAdapter class and options come from the FirebaseUI library
// See: https://github.com/firebase/FirebaseUI-Android
    val options = FirebaseRecyclerOptions.Builder<FriendlyMessage>()
        .setQuery(messagesRef, FriendlyMessage::class.java)
        .build()
    adapter = FriendlyMessageAdapter(options, getUserName())
    binding.progressBar.visibility = ProgressBar.INVISIBLE
    manager = LinearLayoutManager(this)
    manager.stackFromEnd = true
    binding.messageRecyclerView.layoutManager = manager
    binding.messageRecyclerView.adapter = adapter

// Scroll down when a new message arrives
// See MyScrollToBottomObserver for details
    adapter.registerAdapterDataObserver(
    MyScrollToBottomObserver(binding.messageRecyclerView, adapter, manager)
    )

    inner class MessageViewHolder(private val binding: MessageBinding) : ViewHolder(binding.root) {
        fun bind(item: FriendlyMessage) {
            binding.messageTextView.text = item.text
            setTextColor(item.name, binding.messageTextView)

            binding.messengerTextView.text = if (item.name == null) ANONYMOUS else item.name
            if (item.photoUrl != null) {
                loadImageIntoView(binding.messengerImageView, item.photoUrl!!)
            } else {
                binding.messengerImageView.setImageResource(R.drawable.ic_account_circle_black_36dp)
            }
        }
        ...
    }

    inner class ImageMessageViewHolder(private val binding: ImageMessageBinding) :
        ViewHolder(binding.root) {
        fun bind(item: FriendlyMessage) {
            loadImageIntoView(binding.messageImageView, item.imageUrl!!)

            binding.messengerTextView.text = if (item.name == null) ANONYMOUS else item.name
            if (item.photoUrl != null) {
                loadImageIntoView(binding.messengerImageView, item.photoUrl!!)
            } else {
                binding.messengerImageView.setImageResource(R.drawable.ic_account_circle_black_36dp)
            }
        }
    }

    public override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

    public override fun onResume() {
        super.onResume()
        adapter.startListening()
}

    // Disable the send button when there's no text in the input field
// See MyButtonObserver for details
    binding.messageEditText.addTextChangedListener(MyButtonObserver(binding.sendButton))

// When the send button is clicked, send a text message
    binding.sendButton.setOnClickListener {
        val friendlyMessage = FriendlyMessage(
            binding.messageEditText.text.toString(),
            getUserName(),
            getPhotoUrl(),
            null */
/* no image *//*

        )
        db.reference.child(MESSAGES_CHILD).push().setValue(friendlyMessage)
        binding.messageEditText.setText("")
    }*/
