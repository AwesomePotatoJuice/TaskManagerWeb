<section id="loginSection">
  <h2 class="h2 text-center">Login</h2>
  <form action="login" method="post">
    <div class="form-group row">
      <label for="email" class="col-sm-4 col-form-label">Email Address:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="email" name="email"
               placeholder="Email" maxlength="30" required
               value="" >
      </div>
    </div>
    <div class="form-group row">
      <label for="password" class="col-sm-4 col-form-label">Password:</label>
      <div class="col-sm-8">
        <input type="password" class="form-control" id="password" name="password"
               placeholder="Password" maxlength="40" required
               value="">
        <span>&nbsp;Between 8 and 12 characters.</span>
      </div>
    </div>
    <div class="form-group row">
      <div class="col-sm-12">
        <input id="submit" class="btn btn-primary" type="submit" name="submit" value="Login">
      </div>
    </div>
  </form>
  <button class="button" onclick="loadRegisterJSPAjax();">Or register now</button>
  <br/>
  <br/>
</section>