<%--
  Created by IntelliJ IDEA.
  User: truongduong
  Date: 17/11/2022
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript">

  let imageInput = document.getElementById("image-input")
  imageInput.addEventListener("change", function () {
    if (imageInput.files && imageInput.files[0]) {
      let reader = new FileReader();
      reader.onload = function(e) {
        document.getElementById("image-preview").src = e.target.result;
      }
      reader.readAsDataURL(imageInput.files[0]);
    }
  })
</script>
